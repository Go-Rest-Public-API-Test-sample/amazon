package am.mouse.interview.scraper;

import am.mouse.interview.entity.WebComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {
    private final WebDriver driver;
    private ComponentFactory componentFactory = new ComponentFactory();

    public ExtendedFieldDecorator(final WebElement element, final WebDriver driver) {
        super(new DefaultElementLocatorFactory(element));
        this.driver = driver;
    }

    public ExtendedFieldDecorator(final WebDriver driver) {
        super(new DefaultElementLocatorFactory(driver));
        this.driver = driver;
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (WebComponent.class.isAssignableFrom(field.getType())) {
            return decorateComponent(loader, field);
        }
        return super.decorate(loader, field);
    }


    private WebComponent decorateComponent(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return componentFactory.create((Class<? extends WebComponent>) field.getType(), wrappedElement, driver);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }


    private class ComponentFactory {
        public <E extends WebComponent> E create(Class<E> elementClass, WebElement wrappedElement, WebDriver driver) {
            try {
                return elementClass
                        .getConstructor(WebElement.class, WebDriver.class)
                        .newInstance(wrappedElement, driver);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

}