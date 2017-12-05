package Initial;

import org.junit.Test;

public class XMLBuilderTest {

    public OutputBuilder Builder;

    @Test(expected = RuntimeException.class)
    public void TestAddAboveRoot() throws RuntimeException {
        String invalidResult =
                "<orders>" +
                        "<order>" +
                        "</order>" +
                        "</orders>" +
                        "<customer>" +
                        "</customer>";

        Builder = new XMLBuilder();

        Builder.AddBelow("order");

        Builder.AddAbove("customer");
    }
}
