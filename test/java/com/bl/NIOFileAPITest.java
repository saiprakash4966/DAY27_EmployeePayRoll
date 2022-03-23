package com.bl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest 
{

		private static final String HOME = System.getProperty("Path", "C:\\Users\\Admin\\Desktop\\");
		private static final String PLAY_WITH_NIO = "TempPlayGround";

		@Test
		public void givenPathWhenCheckedThenConfirm() throws IOException {
			// Check file exists
			System.out.println("HOME :" + HOME);
			Path homePath = Paths.get(HOME);
			Assert.assertTrue(Files.exists(homePath));
			// Delete file and check file exists
			Path playPath = Paths.get(HOME + "\\" + PLAY_WITH_NIO);
			if (Files.exists(playPath))
				FileUtils.deleteFiles(playPath.toFile());
			Assert.assertTrue(Files.notExists(playPath));
			// Create Directory
			Files.createDirectory(playPath);
			Assert.assertTrue(Files.exists(playPath));
			
			// create file
			IntStream.range(1, 10).forEach(counter -> {
				Path tempFile = Paths.get(playPath + "\\temp" + counter);
				Assert.assertTrue(Files.notExists(tempFile));
				try {
					Files.createFile(tempFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Assert.assertTrue(Files.exists(tempFile));
			});
			
			//List Files, Directories along with Files with extensions
			Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
	        Files.newDirectoryStream(playPath).forEach(System.out::println);
	        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
	        .forEach(System.out::println);

		}
	}


