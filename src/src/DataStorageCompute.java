package src;
public interface DataStorageCompute
{
    int[][] readInput(String inputSource);
    void writeOutput(int[][] matrix, String outputSource, String delimiter);
}
