package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataStoragePrototype implements DataStorageCompute
{
    public int[][] readInput(String inputSource)
    {
        int[][] matrix = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputSource)))
        {
            // add in the matrix creation, read the dimensions in and create the matrix
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return matrix;
    }

    @Override
    public void writeOutput(int[][] matrix, String outputSource, String delimter)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputSource)))
        {
            for (int[] row : matrix)
            {
                for (int value : row)
                {
                    writer.write(value + delimter);
                }
                writer.newLine();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
