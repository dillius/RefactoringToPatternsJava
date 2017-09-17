package Initial.Mappers;

import Initial.Descriptors.AttributeDescriptor;
import Initial.Descriptors.DefaultDescriptor;
import Initial.Descriptors.ReferenceDescriptor;
import Initial.Domain.User;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class DescriptorMapper {
    protected List<AttributeDescriptor> CreateAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();

        result.add(new DefaultDescriptor("remoteId", GetClass(), int.class));
        result.add(new DefaultDescriptor("createdDate", GetClass(), ZonedDateTime.class));
        result.add(new DefaultDescriptor("lastChangedDate", GetClass(), ZonedDateTime.class));
        result.add(new ReferenceDescriptor("createdBy", GetClass(), User.class));
        result.add(new ReferenceDescriptor("lastChangedBy", GetClass(), User.class));
        result.add(new DefaultDescriptor("optimisticLockVersion", GetClass(), int.class));
        return result;
    }

    private Type GetClass()
    {
        return DescriptorMapper.class;
    }
}
