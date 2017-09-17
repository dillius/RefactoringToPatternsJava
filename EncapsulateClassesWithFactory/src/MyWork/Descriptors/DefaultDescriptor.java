package MyWork.Descriptors;

import java.lang.reflect.Type;

public class DefaultDescriptor extends AttributeDescriptor {
    public final String DescriptorName;
    private final Type mapperType;
    private final Type forType;

    public DefaultDescriptor(String descriptorName, Type mapperType, Type forType)
    {
        super(descriptorName, mapperType, forType);
        this.DescriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }
}
