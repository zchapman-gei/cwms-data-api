package cwms.cda.data.dto.forecast;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alias")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSpec {

  @XmlAttribute
  private Integer fcstSpecCode;

  @XmlAttribute
  private Integer officeCode;

  @XmlAttribute
  private String fcstSpecId;

  @XmlAttribute
  private Integer locationCode;

  @XmlAttribute
  private Integer soruceEntity;

  @XmlAttribute
  private String description;

}
