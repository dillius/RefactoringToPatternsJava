package MyWork.Mappers;

import MyWork.Descriptors.AttributeDescriptor;
import MyWork.Descriptors.DefaultDescriptor;
import MyWork.Descriptors.ReferenceDescriptor;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class DescriptorMapperTests {
    private TestingDescriptorMapper testDescriptorMapper;

    @Before
    public void Init() {
        testDescriptorMapper = new TestingDescriptorMapper();
    }

    @Test
    public void it_maps_remoteId_descriptor_as_DefaultDescriptor() {
        AttributeDescriptor remoteIdDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("remoteId");

        Assert.assertThat(remoteIdDescriptor, new IsInstanceOf(DefaultDescriptor.class));
    }

    @Test
    public void it_maps_createdDate_descriptor_as_DefaultDescriptor() {
        AttributeDescriptor createdDateDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("createdDate");

        Assert.assertThat(createdDateDescriptor, new IsInstanceOf(DefaultDescriptor.class));
    }

    @Test
    public void it_maps_lastChangedDate_descriptor_as_DefaultDescriptor() {
        AttributeDescriptor lastChangedDateDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("lastChangedDate");

        Assert.assertThat(lastChangedDateDescriptor, new IsInstanceOf(DefaultDescriptor.class));
    }

    @Test
    public void it_maps_createdBy_descriptor_as_ReferenceDescriptor() {
        AttributeDescriptor createdByDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("createdBy");

        Assert.assertThat(createdByDescriptor, new IsInstanceOf(ReferenceDescriptor.class));
    }

    @Test
    public void it_maps_lastChangedBy_descriptor_ReferenceDescriptor() {
        AttributeDescriptor lastChangedByDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("lastChangedBy");

        Assert.assertThat(lastChangedByDescriptor, new IsInstanceOf(ReferenceDescriptor.class));
    }

    @Test
    public void it_maps_optimisticLockVersion_descriptor_as_DefaultDescriptor() {
        AttributeDescriptor optimisticLockVersionDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("optimisticLockVersion");

        Assert.assertThat(optimisticLockVersionDescriptor, new IsInstanceOf(DefaultDescriptor.class));
    }

    @Test
    public void it_does_not_map_unknown_descriptors() {
        AttributeDescriptor unknownDescriptor =
                testDescriptorMapper.GetMappedDescriptorFor("unknown");

        Assert.assertNull(unknownDescriptor);
    }

    private class TestingDescriptorMapper extends DescriptorMapper {
        List<AttributeDescriptor> descriptors;

        public TestingDescriptorMapper() {
            descriptors = CreateAttributeDescriptors();
        }

        public AttributeDescriptor GetMappedDescriptorFor(String descriptorName) {
            //Would be better to return an optional, but want consistency with other versions.
            return descriptors.stream().filter(descriptor -> Objects.equals(descriptor.DescriptorName, descriptorName)).findFirst().orElse(null);
        }
    }
}