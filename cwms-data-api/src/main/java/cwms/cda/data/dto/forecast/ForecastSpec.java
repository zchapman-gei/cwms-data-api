package cwms.cda.data.dto.forecast;

import cwms.cda.api.errors.FieldException;
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
  private List<String> timeSeriesIds;

  @SuppressWarnings("unused") // required so JAXB can initialize and marshal
  private ForecastSpec() {}

  public ForecastSpec(String specId, String officeId, String locationId, String sourceEntityId, String description,
                      List<String> timeSeriesIds) {
    this.specId = specId;
    this.officeId = officeId;
    this.locationId = locationId;
    this.sourceEntityId = sourceEntityId;
    this.description = description;
    this.timeSeriesIds = timeSeriesIds;
  }

  public String getSpecId() {
    return specId;
  }

  public String getOfficeId() {
    return officeId;
  }

  public String getLocationId() {
    return locationId;
  }

  public String getSourceEntityId() {
    return sourceEntityId;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getTimeSeriesIds() {
    return timeSeriesIds;
  }

  public void validate() throws FieldException {
    //TODO
  }

}
