package cwms.cda.data.dto.forecast;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "forecast-spec")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSpec {

  @Schema(description = "Forecast Spec ID")
  @XmlElement(name = "spec-id")
  String specId;

  @Schema(description = "Office ID that owns the time-series")
  @XmlElement(name = "office-id")
  String officeId;

  @Schema(description = "Location ID")
  @XmlElement(name = "location-id")
  String locationId;

  @Schema(description = "Source Entity ID")
  @XmlElement(name = "source-entity-id")
  String sourceEntityId;

  @Schema(description = "Description of Forecast")
  @XmlAttribute
  private String description;

  @Schema(description = "List of Time Series IDs belonging to this Forecast Spec")
  @XmlAttribute(name = "time-series-ids")
  private List<String> timeSeriesIDs;

}
