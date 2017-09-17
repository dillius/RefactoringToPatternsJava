package Initial.Descriptors;

import java.lang.reflect.Type;

public class AttributeDescriptor {
    public final String DescriptorName;
    private final Type mapperType;
    private final Type forType;

    AttributeDescriptor(String descriptorName, Type mapperType, Type forType)
    {
        this.DescriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }
}
