public class UserCompute implements UserComputeEngine
{
    private String inputSource;
    private String outputSource;
    private String delimiter;
    private static final String DEFAULT_DELIMITER = ",";

    public UserCompute(String inputSource, String outputSource, String delimiter)
    {
        this.inputSource = inputSource;
        this.outputSource = outputSource;
        this.delimiter = delimiter;
    }

    @Override
    public String getInputSource()
    {
        return inputSource;
    }

    @Override
    public String getOutputSource()
    {
        return outputSource;
    }

    @Override
    public String getDelimiter()
    {
        return delimiter;
    }



}
