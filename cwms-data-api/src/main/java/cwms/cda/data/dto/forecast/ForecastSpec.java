package cwms.cda.data.dto.forecast;

import cwms.cda.api.errors.FieldException;
import cwms.cda.data.dto.TimeSeriesIdentifierDescriptors;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "forecast-spec")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSpec {

  @Schema(description = "Forecast Spec ID")
  @XmlElement(name = "spec-id")
  private String specId;

  @Schema(description = "Office ID that owns the time-series")
  @XmlElement(name = "office-id")
  private String officeId;

  @Schema(description = "Location ID")
  @XmlElement(name = "location-id")
  private String locationId;

  @Schema(description = "Source Entity ID")
  @XmlElement(name = "source-entity-id")
  private String sourceEntityId;

  @Schema(description = "Forecast Designator")
  @XmlAttribute
  private String designator;

  @Schema(description = "Description of Forecast")
  @XmlAttribute
  private String description;

  @Schema(description = "List of Time Series IDs belonging to this Forecast Spec")
  @XmlAttribute(name = "time-series-ids")
  private TimeSeriesIdentifierDescriptors timeSeriesIds;

  @SuppressWarnings("unused") // required so JAXB can initialize and marshal
  private ForecastSpec() {}

  public ForecastSpec(String specId, String officeId, String locationId, String sourceEntityId, String designator,
                      String description, TimeSeriesIdentifierDescriptors timeSeriesIds) {
    this.specId = specId;
    this.officeId = officeId;
    this.locationId = locationId;
    this.sourceEntityId = sourceEntityId;
    this.designator = designator;
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

  public String getDesignator() {
    return designator;
  }

  public String getDescription() {
    return description;
  }

  public TimeSeriesIdentifierDescriptors getTimeSeriesIds() {
    return timeSeriesIds;
  }

  public void validate() throws FieldException {
    //TODO
  }

}
