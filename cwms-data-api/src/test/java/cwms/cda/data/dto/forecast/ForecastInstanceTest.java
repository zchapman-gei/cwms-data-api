package cwms.cda.data.dto.forecast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ForecastInstanceTest {

  @Test
  void testRoundTripJson() throws JsonProcessingException
  {
    ForecastInstance i1 = buildForecastInstance();

    ObjectMapper om = buildObjectMapper();

    String jsonString = om.writeValueAsString(i1);
    assertNotNull(jsonString);

    ForecastInstance i2 = om.readValue(jsonString, ForecastInstance.class);
    assertNotNull(i2);

    assertForecastInstanceEquals(i1, i2);
  }

  @Test
  void testRoundTripEmptyJson() throws JsonProcessingException
  {
    ForecastInstance i1 = buildEmptyForecastInstance();

    ObjectMapper om = buildObjectMapper();

    String jsonString = om.writeValueAsString(i1);
    assertNotNull(jsonString);

    ForecastInstance i2 = om.readValue(jsonString, ForecastInstance.class);
    assertNotNull(i2);

    assertForecastInstanceEquals(i1, i2);
  }

  @NotNull
  private ForecastInstance buildForecastInstance() {
    Instant dateTime = Instant.parse("2021-06-21T14:00:10Z");
    Instant issueDateTime = Instant.parse("2022-05-22T12:03:40Z");
    Instant firstDateTime = Instant.parse("2023-08-22T11:02:30Z");
    Instant lastDateTime = Instant.parse("2024-09-22T15:01:00Z");

    HashMap<String, String> metadata = new HashMap<>();
    metadata.put("key1", "value1");
    metadata.put("key2", "value2");
    metadata.put("key3", "value3");

    return new ForecastInstance("instance", "spec", dateTime, issueDateTime,
            firstDateTime, lastDateTime, 5, 3, "test notes",
            metadata, "testFilename.txt", "test file description",
            "test file content".getBytes(StandardCharsets.UTF_8));
  }

  @NotNull
  private ForecastInstance buildEmptyForecastInstance() {
    return new ForecastInstance(null, null, null, null, null,
            null, null, null, null, null, null,
            null, null);
  }

  @NotNull
  public static ObjectMapper buildObjectMapper() {
    return buildObjectMapper(new ObjectMapper());
  }

  @NotNull
  public static ObjectMapper buildObjectMapper(ObjectMapper om) {
    ObjectMapper retval = om.copy();

    retval.setPropertyNamingStrategy(PropertyNamingStrategies.KEBAB_CASE);
    retval.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    retval.registerModule(new JavaTimeModule());

    return retval;
  }

  void assertForecastInstanceEquals(ForecastInstance i1, ForecastInstance i2) {
    assertEquals(i1.getInstanceId(), i2.getInstanceId());
    assertEquals(i1.getSpecId(), i2.getSpecId());
    assertEquals(i1.getDateTime(), i2.getDateTime());
    assertEquals(i1.getIssueDateTime(), i2.getIssueDateTime());
    assertEquals(i1.getFirstDateTime(), i2.getFirstDateTime());
    assertEquals(i1.getLastDateTime(), i2.getLastDateTime());
    assertEquals(i1.getMaxAge(), i2.getMaxAge());
    assertEquals(i1.getTimeSeriesCount(), i2.getTimeSeriesCount());
    assertEquals(i1.getNotes(), i2.getNotes());
    assertEquals(i1.getMetadata(), i2.getMetadata());
    assertEquals(i1.getFilename(), i2.getFilename());
    assertEquals(i1.getFileDescription(), i2.getFileDescription());
    assertArrayEquals(i1.getFileData(), i2.getFileData());
  }

}
