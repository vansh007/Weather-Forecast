package example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata
{
private String status_code;

private String expire_time_gmt;

private String longitude;

private String latitude;

private String language;

private String units;

private String transaction_id;

private String version;

public String getStatus_code ()
{
return status_code;
}

public void setStatus_code (String status_code)
{
this.status_code = status_code;
}

public String getExpire_time_gmt ()
{
return expire_time_gmt;
}

public void setExpire_time_gmt (String expire_time_gmt)
{
this.expire_time_gmt = expire_time_gmt;
}

public String getLongitude ()
{
return longitude;
}

public void setLongitude (String longitude)
{
this.longitude = longitude;
}

public String getLatitude ()
{
return latitude;
}

public void setLatitude (String latitude)
{
this.latitude = latitude;
}

public String getLanguage ()
{
return language;
}

public void setLanguage (String language)
{
this.language = language;
}

public String getUnits ()
{
return units;
}

public void setUnits (String units)
{
this.units = units;
}

public String getTransaction_id ()
{
return transaction_id;
}

public void setTransaction_id (String transaction_id)
{
this.transaction_id = transaction_id;
}

public String getVersion ()
{
return version;
}

public void setVersion (String version)
{
this.version = version;
}

@Override
public String toString()
{
return "ClassPojo [status_code = "+status_code+", expire_time_gmt = "+expire_time_gmt+", longitude = "+longitude+", latitude = "+latitude+", language = "+language+", units = "+units+", transaction_id = "+transaction_id+", version = "+version+"]";
}
}

