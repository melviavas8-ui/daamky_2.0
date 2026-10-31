package aethereal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.ApiStatus.Experimental;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Experimental
public @interface ConfigField {
}
