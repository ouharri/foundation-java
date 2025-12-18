package io.soffa.foundation.model;

import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

class ModelsTest {

    @Test
    void testPojo() {
        Validator validator = ValidatorBuilder.create()
            .with(new SetterTester())
            .with(new GetterTester())
            .build();
        validator.validate("io.soffa.foundation.core.models", new FilterPackageInfo());
    }
}
