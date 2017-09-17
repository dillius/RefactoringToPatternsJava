package Initial.Descriptors;

import javax.management.Attribute;
import java.lang.reflect.Type;

public class BooleanDescriptor extends AttributeDescriptor {
    public final String DescriptorName;
    private final Type mapperType;
    private final Type forType;

    public BooleanDescriptor(String descriptorName, Type mapperType, Type forType)
    {
        super(descriptorName, mapperType, forType);
        this.DescriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }
}
