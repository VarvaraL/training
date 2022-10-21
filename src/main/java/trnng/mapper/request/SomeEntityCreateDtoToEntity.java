package trnng.mapper.request;

import org.mapstruct.Mapping;
import trnng.mapper.DefaultMapper;

public interface SomeEntityCreateDtoToEntity extends DefaultMapper<SomeEntity, DtoForSomeEntity> {
    @Override
    @Mapping(target = "fieldInEntity", source = "dtosFieldName")
    SomeEntity mapTo(DtoForSomeEntity dtoForSomeEntity);
}
