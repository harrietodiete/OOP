 public static String parseType(String aLine)
    {
        Scanner reader = new Scanner(aLine);
        String type = null;
        reader.useDelimiter("= ");
        if(reader.hasNext())
        {
            if(!aLine.isEmpty())
            {
                String getInfo = reader.next();
                if(getInfo.trim().equals("type"))
                {
                   type = reader.next();
                   int textLength = type.length();
                   type = type.substring(1, textLength - 1);
                }
            }
        }
        return type;
    }
        
    public static String parseTitle(String aLine)
    {
        Scanner reader = new Scanner(aLine);
        String title = null;
        reader.useDelimiter("= ");
        if(reader.hasNext())
        {
            if(!aLine.isEmpty())
            {
                String getInfo = reader.next();
                if(getInfo.trim().equals("title"))
                {
                   title = reader.next();
                   int textLength = title.length();
                   title = title.substring(1, textLength - 1);
                }
            }
        }
        return title;
    }
    public static Time parseStart(String aLine)
    {
        Scanner reader = new Scanner(aLine);
        DayPlanner d = new DayPlanner();
        String start = null;
        Time startTime = new Time();
        reader.useDelimiter("= ");
        if(reader.hasNext())
        {
            if(!aLine.isEmpty())
            {
                String getInfo = reader.next();
                if(getInfo.trim().equals("start"))
                {
                   start = reader.next();
                   int textLength = start.length();
                   start = start.substring(1, textLength - 1);
                   startTime = d.getTime(start);
                }
            }
        }
        return startTime;
    }
    
    public static Time parseEnd(String aLine)
    {
        Scanner reader = new Scanner(aLine);
        DayPlanner d = new DayPlanner();
        String end = null;
        Time endTime = new Time();
        reader.useDelimiter("= ");
        if(reader.hasNext())
        {
            if(!aLine.isEmpty())
            {
                String getInfo = reader.next();
                if(getInfo.trim().equals("end"))
                {
                   end = reader.next();
                   int textLength = end.length();
                   end = end.substring(1, textLength - 1);
                   endTime = d.getTime(end);
                }
            }
        }
        return endTime;
    }
    
    public static String parseLocation(String aLine)
    {
        Scanner reader = new Scanner(aLine);
        String location = null;
        reader.useDelimiter("= ");
        if(reader.hasNext())
        {
            if(!aLine.isEmpty())
            {
                String getInfo = reader.next();
                if(getInfo.trim().equals("location"))
                {
                   location = reader.next();
                   int textLength = location.length();
                   location = location.substring(1, textLength - 1);
                }
            }
        }
        return location;
    }
    
    public static String parseComment(String aLine)
    {
        Scanner reader = new Scanner(aLine);
        String comment = "";
        reader.useDelimiter("= ");
        if(reader.hasNext())
        {
            if(!aLine.isEmpty())
            {
                String getInfo = reader.next();
                if(getInfo.trim().equals("comment"))
                {
                   comment = reader.next();
                   int textLength = comment.length();
                   comment = comment.substring(1, textLength - 1);
                }
            }
        }
        return comment;
    }

    public static void main(String[] args) 
    {
        DayPlanner planner = new DayPlanner();
        File fileObject = new File("activities.txt");
        Scanner inputFile = null;
        while (!fileObject.isFile())
        {
            System.out.println("The file does not exist.");
            System.out.println("Please enter an existing file: ");
        }
        try
        {
           inputFile = new Scanner(new FileInputStream(fileObject));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File activities.txt was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }
        
        String next = null;
        String type = "";
        String title = "";
        Time start = new Time();
        Time end = new Time();
        String comment = "";
        String location = "";
        while (inputFile.hasNextLine())
        {
            next = inputFile.nextLine();
            if(next.startsWith("type"))
            {
                type = parseType(next);
            }
            else if(next.startsWith("title"))
            {
                title = parseTitle(next);
            }
            else if(next.startsWith("start"))
            {
                start = parseStart(next);
            }
            else if(next.startsWith("end"))
            {
                end = parseEnd(next);
            }
            else if(next.startsWith("location"))
            {
                location = parseLocation(next);
            }
            else if(next.startsWith("comment"))
            {
                comment = parseComment(next);
            }
            if(next.isEmpty() || inputFile.hasNextLine() == false)
            {
                if(type.equalsIgnoreCase("home"))
                {
                    planner.addHomeActivity(new HomeActivity(type, title, start, end, comment));
                }
                else if(type.equalsIgnoreCase("school"))
                {
                    planner.addSchoolActivity(new SchoolActivity(type, title, start, end, comment));
                }
                else if(type.equalsIgnoreCase("other") && !(location.equals("")))
                {
                    planner.addOtherActivity(new OtherActivity(type, title, start, end, location, comment));
                }
            }
        }
        inputFile.close();
        planner.printActivities();
    }
    