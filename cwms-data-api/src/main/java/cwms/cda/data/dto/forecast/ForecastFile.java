package cwms.cda.data.dto.forecast;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "forecast-file")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastFile {

  @Schema(description = "Forecast Instance ID")
  @XmlElement(name = "instance-id")
  String instanceId;

  @Schema(description = "File's Blob ID")
  @XmlElement(name = "blob-id")
  String blobId;

  @Schema(description = "Forecast Filename")
  @XmlAttribute(name = "filename")
  private String filename;

  @Schema(description = "Description of Forecast File")
  @XmlAttribute
  private String description;

}
