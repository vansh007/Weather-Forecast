package example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyPojo
{
private Forecasts[] forecasts;

private Metadata metadata;

public Forecasts[] getForecasts ()
{
return forecasts;
}

public void setForecasts (Forecasts[] forecasts)
{
this.forecasts = forecasts;
}

public Metadata getMetadata ()
{
return metadata;
}

public void setMetadata (Metadata metadata)
{
this.metadata = metadata;
}

@Override
public String toString()
{
return "ClassPojo [forecasts = "+forecasts+", metadata = "+metadata+"]";
}
}