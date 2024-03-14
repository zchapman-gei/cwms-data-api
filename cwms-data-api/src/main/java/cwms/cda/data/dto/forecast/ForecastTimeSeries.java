package cwms.cda.data.dto.forecast;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alias")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastTimeSeries {

  @XmlAttribute
  private Integer fcstInstCode;

  @XmlAttribute
  private Integer tsCode;

}
