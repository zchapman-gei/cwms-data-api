package cwms.cda.data.dto.forecast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import cwms.cda.api.DataApiTestIT;
import cwms.cda.formatters.json.JsonV2;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ForecastSpecTest {

  @Test
  void testRoundTripJson() throws JsonProcessingException
  {
    ForecastSpec s1 = buildForecastSpec();

    ObjectMapper om = buildObjectMapper();

    String jsonString = om.writeValueAsString(s1);
    assertNotNull(jsonString);

    ForecastSpec s2 = om.readValue(jsonString, ForecastSpec.class);
    assertNotNull(s2);

    assertForecastSpecEquals(s1, s2);
  }

  @Test
  void testRoundTripEmptyJson() throws JsonProcessingException
  {
    ForecastSpec s1 = buildEmptyForecastSpec();

    ObjectMapper om = buildObjectMapper();

    String jsonString = om.writeValueAsString(s1);
    assertNotNull(jsonString);

    ForecastSpec s2 = om.readValue(jsonString, ForecastSpec.class);
    assertNotNull(s2);

    assertForecastSpecEquals(s1, s2);
  }

  @Test
  void testJsonFile() throws IOException {
    String json;
    try (InputStream stream = DataApiTestIT.class.getClassLoader().getResourceAsStream(
            "cwms/cda/data/dto/forecast/forecast_spec_test.json")) {
      assertNotNull(stream);
      json = IOUtils.toString(stream, StandardCharsets.UTF_8);
    }

    ObjectMapper om = buildObjectMapper();
    ForecastSpec fi = om.readValue(json, ForecastSpec.class);

    assertNotNull(fi);
    assertForecastSpecEquals(fi, buildForecastSpec());
  }

  @NotNull
  private ForecastSpec buildForecastSpec() {
    ArrayList<String> timeSeriesIds = new ArrayList<>();
    timeSeriesIds.add("tsid1");
    timeSeriesIds.add("tsid2");
    timeSeriesIds.add("tsid3");

    return new ForecastSpec("spec", "office", "location", "sourceEntity",
            "description", timeSeriesIds);
  }

  @NotNull
  private ForecastSpec buildEmptyForecastSpec() {
    return new ForecastSpec(null, null, null, null, null, null);
  }

  @NotNull
  public static ObjectMapper buildObjectMapper() {
    return JsonV2.buildObjectMapper();
  }

  void assertForecastSpecEquals(ForecastSpec s1, ForecastSpec s2) {
    assertEquals(s1.getSpecId(), s2.getSpecId());
    assertEquals(s1.getOfficeId(), s2.getOfficeId());
    assertEquals(s1.getLocationId(), s2.getLocationId());
    assertEquals(s1.getSourceEntityId(), s2.getSourceEntityId());
    assertEquals(s1.getDescription(), s2.getDescription());
    assertIterableEquals(s1.getTimeSeriesIds(), s2.getTimeSeriesIds());
  }

}
