package hw3;

import java.io.File;
import java.util.Scanner;

public class InvalidTerrainTypeException extends TerrainFileException
{
	public InvalidTerrainTypeException(String message)
	{
		super(message);
	}
}
