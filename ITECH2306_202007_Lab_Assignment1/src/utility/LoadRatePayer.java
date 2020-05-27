package utility;

	import java.io.*;

	import java.nio.charset.StandardCharsets;
	import java.nio.file.*;
	import java.util.*;
	import domain.RatePayer;


	public class LoadRatePayer {
		private String filename;
		private String dir;
		LoadRatePayer listRatePayer= new LoadRatePayer(filename, dir);
		private ArrayList<RatePayer> ratepayers;
 
		public LoadRatePayer(String filename, String dir) {
			// TODO Auto-generated constructor stub
			this.setFilename(filename);
			this.setDir(dir);
		}
		public String getFilename() {
			return filename;
   
    }
		public void setFilename(String filename) {
			this.filename=filename;
     }
   
		public String getDir() {
			return dir;
     
     }
		public void setDir(String dir) {
			this.dir=dir ;
      }
   


		public ArrayList<RatePayer> readRatePayersFromCSV() {


			ArrayList <RatePayer> ratepayers=new ArrayList<>();
			Path pathToFile=Paths.get(this.dir+File.separator+this.filename);
			try {
				BufferedReader br=Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII);
				String line=br.readLine();
				//loop over all the lines
				while(line!=null) {
					//System.out.println(line);


					// to split line based on coma
					String[]attributes=line.split(",");
					Boolean charity=Boolean.parseBoolean(attributes[5]);
					RatePayer r=new RatePayer(attributes[0],attributes[1],attributes[2],attributes[3],attributes[4],charity);
					r.toString();
					line=br.readLine();


				}

			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			return ratepayers;

		}



		public void serialize_objects() {
			ArrayList<RatePayer> payers=this.ratepayers;
			for(int i=0;i<payers.size();i++) {
					try {
						FileOutputStream fileOut=new FileOutputStream(this.dir+File.separator+"tmp\\payer");
						ObjectOutputStream out= new ObjectOutputStream(fileOut);
						out.writeObject(payers.get(i));
						out.close();
						fileOut.close();


					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					System.out.println("Serialized data is saved");

			}
			// TODO Auto-generated method stub

		}

		public void deseralize_objects() {
			System.out.println("\nDesrialized data");
			ArrayList<RatePayer> restoredpayers;
			for(int i=0;i<this.ratepayers.size();i++)
			{
				try
				{
					FileInputStream fileIn=new FileInputStream(this.dir+File.separator+"tmp\\payer");
					ObjectInputStream in=new ObjectInputStream(fileIn);
					try
					{
						RatePayer e=(RatePayer) in.readObject();
						System.out.println(e.toString());
					}
					catch (ClassNotFoundException e)
					{
						e.printStackTrace();

					}
					in.close();
					fileIn.close();
				}

				catch(IOException e)
				{
					e.printStackTrace();
	}
			}
		}

	}
