package net.brekitomasson.fettlol_util.base.Interface;

import net.brekitomasson.fettlol_util.base.UtilClientModule;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Module {
    boolean alwaysEnabled() default false;

    boolean enabledByDefault() default true;

    String description() default "";

    String mod() default "";

    Class<? extends UtilClientModule> client() default UtilClientModule.class;
}
