package cwms.cda.data.dto.forecast;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@XmlRootElement(name = "forecast-instance")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastInstance {

  @Schema(description = "Forecast Instance ID")
  @XmlElement(name = "instance-id")
  String instanceId;

  @Schema(description = "Forecast Spec ID")
  @XmlElement(name = "spec-id")
  String specId;

  @XmlAttribute(name = "date-time")
  private Instant dateTime;

  @XmlAttribute(name = "issue-date-time")
  private Instant issueDateTime;

  @XmlAttribute(name = "first-date-time")
  private Instant firstDateTime;

  @XmlAttribute(name = "last-date-time")
  private Instant lastDateTime;

  @XmlAttribute(name = "max-age")
  private Integer maxAge;

  @XmlAttribute(name = "time-series-count")
  private Integer timeSeriesCount;

  @Schema(description = "Forecast Instance Notes")
  @XmlAttribute
  private String notes;

  @XmlAttribute(name = "metadata")
  private Map<String, String> metadata;

  //@XmlAttribute
  //private byte[] files

}
