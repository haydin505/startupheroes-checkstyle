package startupheroes.checkstyle.checks.custom;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import startupheroes.checkstyle.checks.BaseCheckTestSupport;

import static startupheroes.checkstyle.checks.custom.EntityEqualsHashCodeCheck.MSG_KEY;

/**
 * @author ozlem.ulag
 */
public class EntityEqualsHashCodeCheckTest extends BaseCheckTestSupport {

   @Test
   public void testByWrongInput() throws Exception {
      String[] expectedMessages = {"12: " + getCheckMessage(MSG_KEY)};
      test(expectedMessages, "TestWrongEntity.java");
   }

   @Test
   public void testByCorrectInput() throws Exception {
      String[] expectedMessages = {};
      test(expectedMessages, "TestCorrectEntity.java");
   }

   private void test(String[] expectedMessages, String fileName) throws Exception {
      verify(createCheckConfig(EntityEqualsHashCodeCheck.class,
                               ImmutableMap.of("entityAnnotations", "Entity, javax.persistence.Entity")),
             getPath(fileName),
             expectedMessages);
   }

}
