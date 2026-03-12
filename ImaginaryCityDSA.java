import java.util.*;

class Place{
    String name;
    String type;
    String location;

    Place(String n,String t,String l){
        name=n;
        type=t;
        location=l;
    }
}

public class ImaginaryCityDSA {

    static Scanner sc=new Scanner(System.in);

    static List<Place> cityPlaces=new ArrayList<>();

    static Stack<String> travelHistory=new Stack<>();

    static Queue<String> tourQueue=new LinkedList<>();

    static Map<String,String> quickMap=new HashMap<>();


    static void loadPlaces(){

        cityPlaces.add(new Place("Sky Park","Park","Central City"));
        cityPlaces.add(new Place("Crystal Mall","Shopping","Downtown"));
        cityPlaces.add(new Place("River Walk","Tourist Spot","Riverside"));
        cityPlaces.add(new Place("City Museum","Museum","Old Town"));
        cityPlaces.add(new Place("Sunset Bridge","Landmark","East District"));

        quickMap.put("sky park","Central City");
        quickMap.put("crystal mall","Downtown");
        quickMap.put("river walk","Riverside");
        quickMap.put("city museum","Old Town");
        quickMap.put("sunset bridge","East District");
    }

    static void showPlaces(){

        System.out.println("\n--- City Locations ---");

        for(int i=0;i<cityPlaces.size();i++){
            Place p=cityPlaces.get(i);
            System.out.println((i+1)+". "+p.name+" | "+p.type+" | "+p.location);
        }
    }


    static void searchPlace(){

        sc.nextLine();

        System.out.println("Enter place name to search:");
        String name=sc.nextLine();

        boolean found=false;

        for(Place p:cityPlaces){

            if(p.name.equalsIgnoreCase(name)){

                System.out.println("Found: "+p.name+" | "+p.type+" | "+p.location);

                travelHistory.push(p.name);

                found=true;
                break;
            }
        }

        if(!found)
            System.out.println("Place not found");
    }


    static void sortPlaces(){

        for(int i=0;i<cityPlaces.size()-1;i++){

            for(int j=0;j<cityPlaces.size()-i-1;j++){

                if(cityPlaces.get(j).name.compareTo(cityPlaces.get(j+1).name)>0){

                    Place temp=cityPlaces.get(j);
                    cityPlaces.set(j,cityPlaces.get(j+1));
                    cityPlaces.set(j+1,temp);
                }
            }
        }

        System.out.println("\nPlaces sorted alphabetically:");

        showPlaces();
    }


    static void quickLookup(){

        sc.nextLine();

        System.out.println("Enter place name:");
        String name=sc.nextLine().toLowerCase();

        if(quickMap.containsKey(name)){

            System.out.println("Location Found: "+name+" -> "+quickMap.get(name));

        }else{
            System.out.println("Place not available");
        }
    }


    static void parks(){

        System.out.println("\nCity Parks:");
        System.out.println("1. Sky Park - jogging track, lake view, cycling");
        System.out.println("2. Green Garden - flowers, picnic area");
        System.out.println("3. Kids Fun Park - play area, rides");
    }


    static void shopping(){

        System.out.println("\nShopping Areas:");

        System.out.println("1. Crystal Mall - Fashion, electronics, cinema");
        System.out.println("2. Market Street - street food, handicrafts");
        System.out.println("3. Luxury Plaza - designer stores, jewellery");
    }


    static void transport(){

        System.out.println("\nCity Transport Services:");

        System.out.println("Metro Rail");
        System.out.println("Electric Bus Service");
        System.out.println("City Taxi");
        System.out.println("Bike Rental");
        System.out.println("Tourist Shuttle");
    }


    static void requestTour(){

        sc.nextLine();

        System.out.println("Enter place for guided tour:");
        String place=sc.nextLine();

        tourQueue.add(place);

        System.out.println("Tour request added");
    }


    static void processTour(){

        if(!tourQueue.isEmpty()){

            System.out.println("Tour starting for: "+tourQueue.poll());

        }else{

            System.out.println("No tour requests");
        }
    }


    static void showHistory(){

        System.out.println("\nTravel History:");

        if(travelHistory.isEmpty()){

            System.out.println("No places visited yet");

        }else{

            for(String s:travelHistory)
                System.out.println(s);
        }
    }


    public static void main(String[] args) {

        loadPlaces();

        while(true){

            System.out.println("\n--- IMAGINARY CITY NAVIGATION SYSTEM ---");

            System.out.println("1. Show City Locations");
            System.out.println("2. Search Place");
            System.out.println("3. Sort Places");
            System.out.println("4. Quick Lookup");
            System.out.println("5. Parks");
            System.out.println("6. Shopping Areas");
            System.out.println("7. City Transport");
            System.out.println("8. Request Guided Tour");
            System.out.println("9. Process Tour Request");
            System.out.println("10. Travel History");
            System.out.println("11. Exit");

            int ch=sc.nextInt();

            switch(ch){

                case 1: showPlaces(); break;

                case 2: searchPlace(); break;

                case 3: sortPlaces(); break;

                case 4: quickLookup(); break;

                case 5: parks(); break;

                case 6: shopping(); break;

                case 7: transport(); break;

                case 8: requestTour(); break;

                case 9: processTour(); break;

                case 10: showHistory(); break;

                case 11: System.exit(0);

                default: System.out.println("Invalid choice");
            }
        }
    }
}