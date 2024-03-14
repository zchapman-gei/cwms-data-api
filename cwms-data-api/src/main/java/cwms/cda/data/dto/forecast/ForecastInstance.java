package cwms.cda.data.dto.forecast;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.Map;

@XmlRootElement(name = "alias")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastInstance {

  @XmlAttribute
  private Integer fcstInstCode;

  @XmlAttribute
  private Integer fcstSpecCode;

  @XmlAttribute
  private Instant fcstDateTime;

  @XmlAttribute
  private Instant issueDateTime;

  @XmlAttribute
  private Instant firstDateTime;

  @XmlAttribute
  private Instant lastDateTime;

  @XmlAttribute
  private Integer maxAge;

  @XmlAttribute
  private Integer timeSeriesCount;

  @XmlAttribute
  private Integer fileCount;

  @XmlAttribute
  private String notes;

  @XmlAttribute
  private Map<String, String> fcstInfo;

}
