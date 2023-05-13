package ru.nogen.projectManagement.model;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * The class contains methods for modifying entity.
 */

public class Modifier{

    /**
     * Merge two entities
     * Transfers non-null value of declared fields from entity to targetEntity.
     * Entity and targetEntity must have same Canonical Class name.
     */
    public void mergeTo(AbstractEntity entity, AbstractEntity targetEntity) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        if (!isEntitiesBelongToTheSameClass(entity,targetEntity)){
            return;
        }

        Field[] sourceEntityfields = Class.forName(entity.getClass().getCanonicalName()).getDeclaredFields();
        Class<?> targetClass = targetEntity.getClass();
        Field targetField;
        Object sourceFieldValue;
        boolean isAccessible;

        for (Field sourceField:sourceEntityfields) {

            targetField = targetClass.getDeclaredField(sourceField.getName());
            isAccessible = sourceField.canAccess(entity);

            if(!isAccessible){
                sourceField.setAccessible(true);
                targetField.setAccessible(true);
            }

            sourceFieldValue = sourceField.get(entity);

            if (Objects.nonNull(sourceFieldValue)){
                targetField.set(targetEntity, sourceFieldValue);
            }

            if(!isAccessible){
                sourceField.setAccessible(false);
                targetField.setAccessible(false);
            }
        }
    }

    private boolean isEntitiesBelongToTheSameClass(AbstractEntity entity, AbstractEntity targetEntity) {

        return Objects.nonNull(entity)
                && Objects.nonNull(targetEntity)
                && entity.getClass().getCanonicalName().equals(targetEntity.getClass().getCanonicalName());
    }
}
