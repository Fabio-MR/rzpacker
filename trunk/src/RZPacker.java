import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.io.FileWriter;   // Import the FileWriter class
import java.util.TreeMap;

/**
 *
 * @author TARAN a.k.a toptaran
 */
public class RZPacker
{
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";
    
	public static void main (String[] args)
	{
            
            ////////////////
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Starting RaiderZ Legend Tools V.2.1");
            System.out.println("---------------------------------------------------");
	    System.out.println();
            
            
            
            
            /////////////
		boolean showconfigs = false;
		if (args.length == 0)
		{
			File f = new File("fileindex.msf");
			if (f.exists())
				unpack(".", "./unpacked");
			else
				showconfigs = false;
		}
		else if (args.length == 1)
		{
			if (args[0].equalsIgnoreCase("-genkeys"))
			{
				generateKeys();
			}
			else
				showconfigs = false;
		}
		else if (args.length == 2)
		{
			if (args[0].equalsIgnoreCase("-patch"))
			{
				File f = new File(args[1]);
				if (f.exists() && f.isDirectory())
					patchClient(f.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                        else if (args[0].equalsIgnoreCase("-patchgame"))
			{
				File f = new File(args[1]);
				if (f.exists() && f.isDirectory())
					patchGame(f.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                        else if (args[0].equalsIgnoreCase("-patchgameexe"))
			{
				File f = new File(args[1]);
				if (f.exists() && f.isDirectory())
					patchGameExe(f.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                        
                        else if (args[0].equalsIgnoreCase("-patchnew"))
			{
				File f = new File(args[1]);
				if (f.exists() && f.isDirectory())
					patchNewClient(f.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
			else if (args[0].equalsIgnoreCase("-list"))
			{
				File f = new File(args[1]);
				if (f.exists() && f.isDirectory())
					listFiles(f.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
			else if (args[0].equalsIgnoreCase("-decrypt"))
			{
				File f = new File(args[1]);
				if (f.exists() && !f.isDirectory())
					decryptFile(f);
				else
					showconfigs = false;
			}
			else if (args[0].equalsIgnoreCase("-encrypt"))
			{
				File f = new File(args[1]);
				if (f.exists() && !f.isDirectory())
					encryptFile(f);
				else
					showconfigs = false;
			}
                        else if (args[0].equalsIgnoreCase("-encryptbuildver"))
			{
				File f = new File(args[1]);
				if (f.exists() && !f.isDirectory())
					encryptFile(f);
				else
					showconfigs = false;
			}

			else if (args[0].equalsIgnoreCase("-filehash"))
			{
				File f = new File(args[1]);
				if (f.exists() && f.isDirectory())
					FileHashBuilder.makeFileHash(f.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
		}
		else if (args.length == 3)
		{
			if (args[0].equalsIgnoreCase("-replace"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && f.exists() && f.isDirectory())
					replace(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                        if (args[0].equalsIgnoreCase("-replacewild"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && f.exists() && f.isDirectory())
					replaceWild(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                        
                        
			else if (args[0].equalsIgnoreCase("-unpack"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && (!f.exists() || f.isDirectory()))
					unpack(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
			else if (args[0].equalsIgnoreCase("-buildpatch"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && (!f.exists() || f.isDirectory()))
					PatchBuilder.makePatch(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                        else if (args[0].equalsIgnoreCase("-buildnew"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && (!f.exists() || f.isDirectory()))
					PatchBuilder.makePatchNewClient(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
			else if (args[0].equalsIgnoreCase("-unpackpwe"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && (!f.exists() || f.isDirectory()))
					unpackPWE(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
                         else if (args[0].equalsIgnoreCase("-unpackother"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && (!f.exists() || f.isDirectory()))
					unpackOTHER(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
                        
			else if (args[0].equalsIgnoreCase("-unpackpmang"))
			{
				File f = new File(args[1]);
				File f2 = new File(args[2]);
				if (f.exists() && f.isDirectory() && (!f.exists() || f.isDirectory()))
					unpackPmang(f.getAbsolutePath().replace("\\", "/"), f2.getAbsolutePath().replace("\\", "/"));
				else
					showconfigs = false;
			}
			else
				showconfigs = false;
		}
		if (showconfigs)
		{
			System.out.println("USAGE:");
			System.out.println("-- replace data, clientdir - where is fileindex present, filesdir - where is dir Data present with new files");
			System.out.println("-replace [clientdir] [filesdir]");
			System.out.println();
			System.out.println("-- unpack data, clientdir - where is fileindex present, filesdir - where is unpack files");
			System.out.println("-unpack [clientdir] [outdir]");
			System.out.println();
                        System.out.println("-- unpack other client data, clientdir - where is fileindex present, filesdir - where is unpack files");
			System.out.println("-unpackother [clientdir] [outdir]");
			System.out.println();
			System.out.println("-- patch all *.exe, *.dat and Fileindex.msf  and change crypt to our, clientdir - where is fileindex present");
			System.out.println("-patch [clientdir]");
			System.out.println();
                        System.out.println("-- patchnew all *.exe, *.dat and Fileindex.msf with old KEY and change crypt to our, clientdir - where is fileindex present");
			System.out.println("-patchnew [clientdir]");
			System.out.println();
                        System.out.println("-- patchgameexe all Raiderz.exe and change crypt to our, clientdir - where is the executables present");
			System.out.println("-patchgameexe [clientdir]");
			System.out.println();
			System.out.println("-- list all files from Fileindex.msf");
			System.out.println("-list [clientdir]");
			System.out.println();
			System.out.println("-- decrypt file (for example: buildver.mvf, RaiderZ Launcher.dat, recovery.dat) and save it to filename.txt");
			System.out.println("-decrypt [file]");
			System.out.println();
			System.out.println("-- encrypt file (for example: buildver.mvf, RaiderZ Launcher.dat, recovery.dat) and save it to filename.dat");
			System.out.println("-encrypt [file]");
			System.out.println();
			System.out.println("-- make hash of client files (filehash.msf)");
			System.out.println("-filehash [clientdir]");
			System.out.println();
			System.out.println("-- build patch (before build patch do not forget to make hash)");
			System.out.println("-buildpatch [newclientdir] [oldclientdir]");
			System.out.println();
                        System.out.println("-- buildnew made a patch just with folder files not the fileindex");
			System.out.println("-buildnew [newclientdir] [oldclientdir]");
			System.out.println();
			System.out.println("-- generate new private and public keys");
			System.out.println("-genkeys");
		}
	}
	
         
        
	public static void replace(String clientdir, String filesdir)
	{       
                System.out.println("---------------------------------------------------");
		System.out.println("Loading fileindex...");
		MsfFile mf = MsfFile.read(clientdir);
		if (mf == null)
		{
			System.out.println("Fileindex read/parse error!");
			return;
		}
		System.out.println("Done!");
		System.out.println("---------------------------------------------------");
		System.out.println("Loading files...");
		ArrayList<String> files = new ArrayList<String>();
		FileUtils.parsedir(files, filesdir, filesdir + "/");
		System.out.println("Done!");
		System.out.println("---------------------------------------------------");
		System.out.println("Process replacing...");
		ArrayList<String> filesf = new ArrayList<String>();
		TreeMap<String, TreeMap<String, String>> mrfreplace = new TreeMap<String, TreeMap<String, String>>();
		//settting marks for mrf files
		for (String file: files)
		{
			String filemrf = file.substring(0, file.indexOf("/", file.indexOf("/") + 1));
			String filename = file.substring(file.indexOf("/", file.indexOf("/") + 1) + 1);
			for (String mrfname: mf.fileindex.keySet())
			{
				boolean founded = false;
				if (mrfname.startsWith(filemrf))
				{
					TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
					for (MsfEntry me: mrfindex.values())
					{
						if (me.fileName.equalsIgnoreCase(filename))
						{
							founded = true;
							// setmark
							me.filedata = new byte[0];
							TreeMap<String, String> fls = mrfreplace.get(mrfname);
							if (fls == null)
							{
								fls = new TreeMap<String, String>();
								mrfreplace.put(mrfname, fls);
							}
							fls.put(me.fileName, file);
							filesf.add(file);
							break;
						}
					}
				}
				if (founded)
					break;
			}
		}
		
		for (String file: filesf)
		{
			files.remove(file);
		}

		if (mrfreplace.isEmpty())
		{
			System.out.println("No file found to replace");
                        System.out.println("---------------------------------------------------");
		}
		else
		{
			System.out.println("Files will be replaced:");
			for (String mrfname: mrfreplace.keySet())
			{
				//System.out.println(mrfname);
                                System.out.println(mrfname); // mrfname = Data/arquivo.mrf
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				for (String rpfile: fls.keySet())
					System.out.println("   -"+rpfile);
                                System.out.println();
			}

			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println("Read " + mrfname + "...");
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
				for (MsfEntry me: mrfindex.values())
				{
					if (me.filedata == null)
					{
						me.filedata = me.getOriginalFileData(clientdir);
					}
					else
					{
						for (String rpfile: fls.keySet())
						{
							if (rpfile.equals(me.fileName)) // rpfile = arquivo da pasta me.filename é o do game
							{
								me.filedata = me.putFileData(filesdir + "/" + fls.get(rpfile));
							}
						}
					}
				}
				System.out.println("Done!");
                                System.out.println("---------------------------------------------------");
				System.out.println("Write " + mrfname + "...");
				File f = new File(clientdir + "/" + mrfname);
				FileOutputStream fos = null;
				try
				{
					fos = new FileOutputStream(f);
					for (Integer offset: mrfindex.keySet())
					{
						MsfEntry me = mrfindex.get(offset);
						me.offset = (int) fos.getChannel().position();
						fos.write(me.filedata);
						me.filedata = null;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (fos != null)
						try
						{
							fos.close();
						}
						catch(Exception e)
						{
						}
				}
				System.out.println("Done!");
                                System.out.println("---------------------------------------------------");
			}
		}
		System.out.println("Process adding...");
		mrfreplace = new TreeMap<String, TreeMap<String, String>>();
		//settting marks for mrf files
		for (String file: files)
		{
			String filemrf = file.substring(0, file.indexOf("/", file.indexOf("/") + 1));
			String filename = file.substring(file.indexOf("/", file.indexOf("/") + 1) + 1);
			for (String mrfname: mf.fileindex.keySet())
			{
				if (mrfname.startsWith(filemrf))
				{
					TreeMap<String, String> fls = mrfreplace.get(mrfname);
					if (fls == null)
					{
						fls = new TreeMap<String, String>();
						mrfreplace.put(mrfname, fls);
					}
					fls.put(filename, file);
					break;
				}
			}
		}

		if (mrfreplace.isEmpty())
		{
			System.out.println("No file found to add");
                        System.out.println("---------------------------------------------------");
		}
		else
		{
			System.out.println("Files to add:");
			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println(mrfname);
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				for (String rpfile: fls.keySet())
					System.out.println("  "+rpfile);
			}

			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println("Read " + mrfname + "...");
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
				int offsetmax = 0;
				for (MsfEntry me: mrfindex.values())
				{
					if (me.filedata == null)
					{
						me.filedata = me.getOriginalFileData(clientdir);
						if (offsetmax < me.offset)
							offsetmax = me.offset;
					}
				}
				for (String rpfile: fls.keySet())
				{
					offsetmax++;
					MsfEntry me = new MsfEntry(mrfname, rpfile);
					me.filedata = me.putFileData(filesdir + "/" + fls.get(rpfile));
					mrfindex.put(offsetmax, me);
				}
				
				System.out.println("Done!");
                                System.out.println("---------------------------------------------------");
				System.out.println("Write " + mrfname + "...");
				File f = new File(clientdir + "/" + mrfname);
				FileOutputStream fos = null;
				try
				{
					fos = new FileOutputStream(f);
					for (Integer offset: mrfindex.keySet())
					{
						MsfEntry me = mrfindex.get(offset);
						me.offset = (int) fos.getChannel().position();
						fos.write(me.filedata);
						me.filedata = null;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (fos != null)
						try
						{
							fos.close();
						}
						catch(Exception e)
						{
						}
				}
				System.out.println("Done!");
                                System.out.println("---------------------------------------------------");
			}
		}
		
		System.out.println("Saving fileindex...");
		if (!mf.save(clientdir))
		{
			System.out.println("Fileindex save error!");
			return;
		}
		System.out.println("Finished Replace!");
                System.out.println("---------------------------------------------------");
               
	}
	
	public static void unpack(String clientdir, String outdir)
	{
		File f = new File(outdir);
		if (!f.exists())
			f.mkdirs();
		System.out.println("Loading fileindex...");
		MsfFile mf = MsfFile.read(clientdir);
		if (mf == null)
		{
			System.out.println("Fileindex read/parse error!");
			return;
		}
		System.out.println("Done!");
                System.out.println("---------------------------------------------------");
		
		//calculate filecount
		int count = 0;
		for (TreeMap<Integer, MsfEntry> mrfindex: mf.fileindex.values())
			count += mrfindex.size();
		System.out.println("Unpacking " + count + " files...");
		int curcount = 0;
		for (String mrfname: mf.fileindex.keySet())
		{
			String mrffolder = outdir + "/" + mrfname.substring(0, mrfname.lastIndexOf("."));
			TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
			for (MsfEntry me: mrfindex.values())
			{
				if (me.fileName.indexOf("/") > 0)
					new File(mrffolder + "/" + me.fileName.substring(0, me.fileName.lastIndexOf("/"))).mkdirs();
				else
					new File(mrffolder + "/").mkdirs();
				File file = new File(mrffolder + "/" + me.fileName);
				FileOutputStream fos = null;
				try
				{
					fos = new FileOutputStream(file);
					fos.write(me.getFileData(clientdir));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (fos != null)
						try
						{
							fos.close();
						}
						catch(Exception e)
						{
						}
				}
				curcount++;
				if (curcount % 100 == 0)
					System.out.println("Processed [" + curcount + "/" + count + "] files.");
			}
		}
		System.out.println("Finished Unpack!");
                System.out.println("---------------------------------------------------");
	}
	
	public static void unpackPWE(String clientdir, String outdir)
	{
		EciesCryptoPP.privateKey = EciesCryptoPP.PWEKey;
		unpack(clientdir, outdir);
	}
	
        
         public static void unpackOTHER(String clientdir, String outdir)
	{
		EciesCryptoPP.privateKey = EciesCryptoPP.otherprivateKey;
		unpack(clientdir, outdir);
	}
        
	public static void unpackPmang(String clientdir, String outdir)
	{
		EciesCryptoPP.privateKey = EciesCryptoPP.PmangKey;
		unpack(clientdir, outdir);
	}
	
	public static void patchClient(String clientdir)
	{
		changeEncription(clientdir + "/" + "buildver.mvf", EciesCryptoPP.PWEKeyBuildver);
		changeEncription(clientdir + "/" + "fileindex.msf", EciesCryptoPP.PWEKey);
		changeEncription(clientdir + "/" + "RaiderZ Launcher.dat", EciesCryptoPP.PWEKeyUpdaterConf);
		changeEncription(clientdir + "/" + "recovery.dat", EciesCryptoPP.PWEKeyUpdaterConf);
		
		replaceKey(clientdir + "/" + "Raiderz.exe", EciesCryptoPP.PWEKey, EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "Raiderz Launcher.exe", EciesCryptoPP.PWEKeyUpdaterConf, EciesCryptoPP.privateKey);
		replaceKey(clientdir + "/" + "recovery.exe", EciesCryptoPP.PWEKeyUpdaterConf, EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "Raiderz Launcher.exe", EciesCryptoPP.PWEKeyBuildver, EciesCryptoPP.privateKey);
		replaceKey(clientdir + "/" + "recovery.exe", EciesCryptoPP.PWEKeyBuildver, EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "Raiderz Launcher.exe", EciesCryptoPP.PWEKeyLauncherHz, EciesCryptoPP.privateKey);
		replaceKey(clientdir + "/" + "recovery.exe", EciesCryptoPP.PWEKeyFileHash, EciesCryptoPP.privateKey);
	}
	
        
        public static void patchNewClient(String clientdir)
	{
		changeEncription(clientdir + "/" + "buildver.mvf", EciesCryptoPP.privateKey);
		changeEncription(clientdir + "/" + "fileindex.msf", EciesCryptoPP.privateKey);
		changeEncription(clientdir + "/" + "lua5.2.dll", EciesCryptoPP.privateKey);
		changeEncription(clientdir + "/" + "recovery.dat", EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "BugEnch.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "Raiderz Launcher.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
		replaceKey(clientdir + "/" + "recovery.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "Raiderz Launcher.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
		replaceKey(clientdir + "/" + "recovery.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
		
		replaceKey(clientdir + "/" + "Raiderz Launcher.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
		replaceKey(clientdir + "/" + "recovery.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
	}
        
        
        public static void patchGameExe(String clientdir)
	{
            		replaceKey(clientdir + "/" + "Raiderz.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.privateKey);
        }
        
        
        public static void patchGame(String clientdir)
	{
		
		replaceKey(clientdir + "/" + "Raiderz.exe", EciesCryptoPP.OldprivateKey, EciesCryptoPP.PWEKey);
		
        }
        
        
	public static boolean changeEncription(String file, byte[] oldkey)
	{
		File f = new File(file);
		if (!f.exists())
			return false;
			boolean allisok = true;
			System.out.println("Read " + f.getName() + " file...");
			FileInputStream fis = null;
			byte[] data = new byte[0];
			try
			{
				fis = new FileInputStream(f);
				data = new byte[fis.available()];
				fis.read(data);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Read error!");
				allisok = false;
			}
			finally
			{
				if (fis != null)
					try
					{
						fis.close();
					}
					catch(Exception e)
					{
					}
			}

			if (allisok)
			{
				System.out.println("Decrypt...");
				data = EciesCryptoPP.decrypt(oldkey, oldkey.length, data, data.length);
				System.out.println("Encrypt...");
				data = EciesCryptoPP.encrypt(data);
			}

			System.out.println("Save file...");
			FileOutputStream fos = null;
			try
			{
				fos = new FileOutputStream(f);
				fos.write(data);
                              
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Save error!");
				return false;
			}
			finally
			{
				if (fos != null)
					try
					{
						fos.close();
					}
					catch(Exception e)
					{
					}
			}
			System.out.println("Finished ChangeEncryption!");
                        System.out.println("---------------------------------------------------");
			return true;
	}
	
	public static boolean replaceKey(String file, byte[] oldkey, byte[] newkey)
	{
		File f = new File(file);
		if (!f.exists())
			return false;
			System.out.println("Patch " + f.getName() + " file...");
			System.out.println("Read file...");
			FileInputStream fis = null;
			byte[] exedata = new byte[0];
			boolean allisok = true;
			try
			{
				fis = new FileInputStream(f);
				exedata = new byte[fis.available()];
				fis.read(exedata);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Read error!");
				allisok = false;
			}
			finally
			{
				if (fis != null)
					try
					{
						fis.close();
					}
					catch(Exception e)
					{
					}
			}
			
			if (!allisok)
			{
				return false;
			}

			System.out.println("Searching key...");
			int i = 0;
			for (;i < exedata.length; i++)
			{
				if (exedata[i] == oldkey[0])
				{
					boolean founded = true;
					for (int j = 0; j < oldkey.length; j++)
					{
						if (exedata[i + j] != oldkey[j])
						{
							founded = false;
							break;
						}
					}
					if (founded)
						break;
				}
			}
			if (i == exedata.length)
			{
				System.out.println("Key not found!");
				return false;
			}
			System.out.println("Patching...");
			System.arraycopy(newkey, 0, exedata, i, newkey.length);

			System.out.println("Save exe file...");
			FileOutputStream fos = null;
			try
			{
				fos = new FileOutputStream(f);
				fos.write(exedata);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Save error!");
				return false;
			}
			finally
			{
				if (fos != null)
					try
					{
						fos.close();
					}
					catch(Exception e)
					{
					}
			}
			System.out.println("Finished Replace Key!");
                        System.out.println("---------------------------------------------------");
			return true;
	}
	
	public static void listFiles(String clientdir)
	{
		System.out.println("Loading fileindex...");
		MsfFile mf = MsfFile.read(clientdir);
		if (mf == null)
		{
			System.out.println("Fileindex read/parse error!");
			return;
		}
		System.out.println("Done!");
		System.out.println("---------------------------------------------------");
                
		StringBuilder sb = new StringBuilder();
		sb.append("mrffilename").append(" ").append("filename").append(" ").append("size").append(" ").append("checksumm").append("\r\n");
		int count = 0;
		for (String mrfname: mf.fileindex.keySet())
		{
			TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
			for (MsfEntry me: mrfindex.values())
			{
				sb.append(me.mrfFileName).append(" ").append(me.fileName).append(" ").append(me.size).append(" ").append(me.xorkey).append("\r\n");
				count++;
			}
		}
		System.out.println("Processed [" + count + "] files.");
		
		System.out.println("Saving to fileindex.txt...");
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(new File(clientdir + "/fileindex.txt"));
			fos.write(sb.toString().getBytes(Charset.forName("UTF-8")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Save error!");
			return;
		}
		finally
		{
			if (fos != null)
				try
				{
					fos.close();
				}
				catch(Exception e)
				{
				}
		}
		System.out.println("Finished List!");
                System.out.println("---------------------------------------------------");
	}
	
	public static boolean decryptFile(File f)
	{
			boolean allisok = true;
			System.out.println("Read " + f.getName() + " file...");
			FileInputStream fis = null;
			byte[] data = new byte[0];
			try
			{
				fis = new FileInputStream(f);
				data = new byte[fis.available()];
				fis.read(data);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Read error!");
				allisok = false;
			}
			finally
			{
				if (fis != null)
					try
					{
						fis.close();
					}
					catch(Exception e)
					{
					}
			}

			if (allisok)
			{
				System.out.println("Decrypt...");
				data = EciesCryptoPP.decrypt(data);
			}

			System.out.println("Save file to " + f.getName() + ".txt ...");
			f = new File(f.getAbsolutePath() + ".txt");
			FileOutputStream fos = null;
			try
			{
				fos = new FileOutputStream(f);
				fos.write(data);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Save error!");
				return false;
			}
			finally
			{
				if (fos != null)
					try
					{
						fos.close();
					}
					catch(Exception e)
					{
					}
			}
			System.out.println("Finished Decrypt!");
                        System.out.println("---------------------------------------------------");
			return true;
	}
	
	public static boolean encryptFile(File f)
	{
			boolean allisok = true;
			System.out.println("Read " + f.getName() + " file...");
			FileInputStream fis = null;
			byte[] data = new byte[0];
			try
			{
				fis = new FileInputStream(f);
				data = new byte[fis.available()];
				fis.read(data);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Read error!");
				allisok = false;
			}
			finally
			{
				if (fis != null)
					try
					{
						fis.close();
					}
					catch(Exception e)
					{
					}
			}

			if (allisok)
			{
				System.out.println("Encrypt...");
				data = EciesCryptoPP.encrypt(data);
			}

                        String s = f.getName();
                        String x = (s.substring(0, s.length() - 4));
                        
			System.out.println("Save file to " + x + " ...");
			f = new File("NewVersion/" + x);
			FileOutputStream fos = null;
			try
			{
				fos = new FileOutputStream(f);
				fos.write(data);
                                
                               // FileWriter myWriter = new FileWriter("filename.txt");
                               // myWriter.write("Files in Java might be tricky, but it is fun enough!");
                               // myWriter.close();
                                 
                               // File nex = new File("Data/"+ f.getName());
                                //if(nex.createNewFile())
                               //    System.out.println("File creation successfull");
                                  
                                 
                                
                                
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Save error!");
				return false;
			}
			finally
			{
				if (fos != null)
					try
					{
						fos.close();
					}
					catch(Exception e)
					{
					}
			}
			System.out.println("Finished Encrypt!");
                        System.out.println("---------------------------------------------------");
                        
			return true;
	}
        
        public static void replaceWild(String clientdir, String filesdir)
	{
		EciesCryptoPP.privateKey = EciesCryptoPP.WildKey;
                System.out.println("---------------------------------------------------");
                System.out.println("Loading fileindex...");
		MsfFile mf = MsfFile.readwild(clientdir);
		if (mf == null)
		{
			System.out.println("Fileindex read/parse error!");
			return;
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Loading files...");
		ArrayList<String> files = new ArrayList<String>();
		FileUtils.parsedir(files, filesdir, filesdir + "/");
		System.out.println("Done.");
		
		System.out.println("Process replacing...");
		ArrayList<String> filesf = new ArrayList<String>();
		TreeMap<String, TreeMap<String, String>> mrfreplace = new TreeMap<String, TreeMap<String, String>>();
		//settting marks for mrf files
		for (String file: files)
		{
			String filemrf = file.substring(0, file.indexOf("/", file.indexOf("/") + 1));
			String filename = file.substring(file.indexOf("/", file.indexOf("/") + 1) + 1);
			for (String mrfname: mf.fileindex.keySet())
			{
				boolean founded = false;
				if (mrfname.startsWith(filemrf))
				{
					TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
					for (MsfEntry me: mrfindex.values())
					{
						if (me.fileName.equalsIgnoreCase(filename))
						{
							founded = true;
							// setmark
							me.filedata = new byte[0];
							TreeMap<String, String> fls = mrfreplace.get(mrfname);
							if (fls == null)
							{
								fls = new TreeMap<String, String>();
								mrfreplace.put(mrfname, fls);
							}
							fls.put(me.fileName, file);
							filesf.add(file);
							break;
						}
					}
				}
				if (founded)
					break;
			}
		}
		
		for (String file: filesf)
		{
			files.remove(file);
		}

		if (mrfreplace.isEmpty())
		{
			System.out.println("No one file found to replace");
		}
		else
		{
			System.out.println("Files will be replaced:");
			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println(mrfname);
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				for (String rpfile: fls.keySet())
					System.out.println("  "+rpfile);
			}

			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println("Read " + mrfname + "...");
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
				for (MsfEntry me: mrfindex.values())
				{
					if (me.filedata == null)
					{
						me.filedata = me.getOriginalFileData(clientdir);
					}
					else
					{
						for (String rpfile: fls.keySet())
						{
							if (rpfile.equals(me.fileName)) // rpfile = arquivo da pasta me.filename é o do game
							{
								me.filedata = me.putFileData(filesdir + "/" + fls.get(rpfile));
							}
						}
					}
				}
				System.out.println("Done.");
				System.out.println("Write " + mrfname + "...");
				File f = new File(clientdir + "/" + mrfname);
				FileOutputStream fos = null;
				try
				{
					fos = new FileOutputStream(f);
					for (Integer offset: mrfindex.keySet())
					{
						MsfEntry me = mrfindex.get(offset);
						me.offset = (int) fos.getChannel().position();
						fos.write(me.filedata);
						me.filedata = null;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (fos != null)
						try
						{
							fos.close();
						}
						catch(Exception e)
						{
						}
				}
				System.out.println("Done.");
			}
		}
		
		System.out.println("Process adding...");
		mrfreplace = new TreeMap<String, TreeMap<String, String>>();
		//settting marks for mrf files
		for (String file: files)
		{
			String filemrf = file.substring(0, file.indexOf("/", file.indexOf("/") + 1));
			String filename = file.substring(file.indexOf("/", file.indexOf("/") + 1) + 1);
			for (String mrfname: mf.fileindex.keySet())
			{
				if (mrfname.startsWith(filemrf))
				{
					TreeMap<String, String> fls = mrfreplace.get(mrfname);
					if (fls == null)
					{
						fls = new TreeMap<String, String>();
						mrfreplace.put(mrfname, fls);
					}
					fls.put(filename, file);
					break;
				}
			}
		}

		if (mrfreplace.isEmpty())
		{
			System.out.println("No file found to add");
		}
		else
		{
			System.out.println("Files will be add:");
			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println(mrfname);
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				for (String rpfile: fls.keySet())
					System.out.println("  "+rpfile);
			}

			for (String mrfname: mrfreplace.keySet())
			{
				System.out.println("Read " + mrfname + "...");
				TreeMap<String, String> fls = mrfreplace.get(mrfname);
				TreeMap<Integer, MsfEntry> mrfindex = mf.fileindex.get(mrfname);
				int offsetmax = 0;
				for (MsfEntry me: mrfindex.values())
				{
					if (me.filedata == null)
					{
						me.filedata = me.getOriginalFileData(clientdir);
						if (offsetmax < me.offset)
							offsetmax = me.offset;
					}
				}
				for (String rpfile: fls.keySet())
				{
					offsetmax++;
					MsfEntry me = new MsfEntry(mrfname, rpfile);
					me.filedata = me.putFileData(filesdir + "/" + fls.get(rpfile));
					mrfindex.put(offsetmax, me);
				}
				
				System.out.println("Done!");
				System.out.println("Write " + mrfname + "...");
				File f = new File(clientdir + "/" + mrfname);
				FileOutputStream fos = null;
				try
				{
					fos = new FileOutputStream(f);
					for (Integer offset: mrfindex.keySet())
					{
						MsfEntry me = mrfindex.get(offset);
						me.offset = (int) fos.getChannel().position();
						fos.write(me.filedata);
						me.filedata = null;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (fos != null)
						try
						{
							fos.close();
						}
						catch(Exception e)
						{
						}
				}
				System.out.println("Done!");
                                System.out.println("---------------------------------------------------");
			}
		}
		
		System.out.println("Saving fileindex...");
		if (!mf.savewild(clientdir))
		{
			System.out.println("Fileindex save error!");
			return;
		}
		System.out.println("Done!");
		System.out.println("---------------------------------------------------");
	}
        
        
	public static void generateKeys()
	{
		if (EciesCryptoPP.generateAndSaveKeys())
			System.out.println("Keys successfully generated and saved!");
		else
			System.out.println("Save error!");
	}
}
