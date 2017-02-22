import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSJavaAPIDemo {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		/*
		 * conf.addResource(new Path( "/u/hadoop-1.0.2/conf/core-site.xml"));
		 * conf.addResource(new Path( "/u/hadoop-1.0.2/conf/hdfs-site.xml"));
		 */

		FileSystem fileSystem = FileSystem.get(conf);

		System.out.println(fileSystem.getUri());

		Path file = new Path("/user/mwuser/test/demo.txt");
		if (fileSystem.exists(file)) {
			System.out.println("File exists.");
		} else {
			// Writing to file
			FSDataOutputStream outStream = fileSystem.create(file);
			outStream.writeUTF("Welcome to HDFS Java API!!!");
			outStream.close();
		}

		// Reading from file
		FSDataInputStream inStream = fileSystem.open(file);
		String data = inStream.readUTF();
		System.out.println(data);
		inStream.close();

		// deleting the file. Non-recursively.
		// fileSystem.delete(file, false);

		// fileSystem.close();

		/*Path file1 = new Path("/tmp/jdk-7u45-linux-x64.rpm");

		DistributedFileSystem dfs = (DistributedFileSystem) fileSystem;
		FileStatus fstat = dfs.getFileStatus(file1);
		BlockLocation[] blocks = dfs.getFileBlockLocations(fstat, 0,
				fstat.getLen());
		for (BlockLocation block : blocks) {
			//String[] hosts = block.getHosts();
			String[] hosts=block.getNames();
			for (String host : hosts) {
				System.out.println(host);
			}
		}*/
		/*
		 * FSDataInputStream inStream1 = fileSystem.open(file1);
		 * 
		 * String data1 = inStream1.readUTF(); System.out.println(data1);
		 * inStream1.close();
		 */

		fileSystem.close();
	}
}
