public class NBody{
	public static double readRadius(String PlanetsTxtPath){	
		In in = new In(PlanetsTxtPath);
		int number_of_planets=in.readInt();
		double radius=in.readDouble();
		return radius;
		
	}
	public static Planet[] readPlanets(String PlanetsTxtPath){
		In in = new In(PlanetsTxtPath);
		int number_of_planets=in.readInt();
		Planet[] Planet_array = new Planet[number_of_planets];
		double radius=in.readDouble();
		
		for (int i = 0; i < number_of_planets; i++) {
		
			double xPos=in.readDouble();
			double yPos=in.readDouble();
			double xVel=in.readDouble();
			double yVel=in.readDouble();
			double mass=in.readDouble();
			String imgFileName=in.readString();
			Planet_array[i]=new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
			
			
			
		}
		return Planet_array;
	}
	
	
}