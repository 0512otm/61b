public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
	static final double G=6.67e-11;
    
    public Planet(double xP, double yP, double xV,double yV, double m, String img) {
       xxPos=xP;
       yyPos=yP;
       xxVel=xV;
       yyVel=yV;
       mass=m;
       imgFileName=img; 
    }
    public Planet(Planet p){
       this.xxPos=p.xxPos;
       this.yyPos=p.yyPos;
       this.xxVel=p.xxVel;
       this.yyVel=p.yyVel;
       this.mass=p.mass;
       this.imgFileName=p.imgFileName; 
    }
	public double calcDistance(Planet p) {
		double dx=this.xxPos-p.xxPos;
		double dy=this.yyPos-p.yyPos;
		double distance=Math.sqrt(dx*dx+dy*dy);
		return distance;
	}
	
	public double calcForceExertedBy(Planet p) {
		
		double F=G*this.mass*p.mass/(calcDistance(p)*calcDistance(p));
		return F;
	}
	
	public double calcForceExertedByX(Planet p) {
		double Fx=calcForceExertedBy(p)*(p.xxPos-this.xxPos)/calcDistance(p);
		return Fx;
	}
	public double calcForceExertedByY(Planet p) {
		double Fx=calcForceExertedBy(p)*(p.yyPos-this.yyPos)/calcDistance(p);
		return Fx;
	}
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double Netxforce=0;
		for (Planet p : allPlanets){
			if (!(this.equals(p))){
				Netxforce=Netxforce+calcForceExertedByX(p);
			}
		}
		return Netxforce;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double Netyforce=0;
		for (Planet p : allPlanets){
			if (!(this.equals(p))){
				Netyforce=Netyforce+calcForceExertedByY(p);
			}
		}
		return Netyforce;
	}
	public void update(double dt, double fX, double fY){
		double ax=fX/this.mass;
		double ay=fY/this.mass;
		xxVel=this.xxVel+dt*ax;
		yyVel=this.yyVel+dt*ay;
		xxPos=this.xxPos+dt*Vnewx;
		yyPos=this.yyPos+dt*Vnewy;
		
		
	}

}