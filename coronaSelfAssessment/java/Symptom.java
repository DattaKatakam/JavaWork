
public class Symptom {

	private String Name;
    private Boolean Fever;
    private Boolean Cold;
    private Boolean Cough;
    private Boolean Headache;
    private Boolean Body_aches;
    private Boolean Breathing_Trouble;
    private Boolean Vomiting;
	private String Advice;

	public String getName() {
		return Name;
	}

    public Boolean getFever() {
		return Fever;
	}
	public Boolean getCold() {
		return Cold;
	}
	public Boolean getCough() {
		return Cough;
	}
	public Boolean getHeadache() {
		return Headache;
	}
	public Boolean getBody_aches() {
		return Body_aches;
	}
	public Boolean getBreathing_Trouble() {
		return Breathing_Trouble;
	}
	public Boolean getVomiting() {
		return Vomiting;
	}
	
	public String getAdvice() {
		return Advice;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public void setFever(Boolean fever) {
		Fever = fever;
	}
	public void setCold(Boolean cold) {
		Cold = cold;
	}
	public void setCough(Boolean cough) {
		Cough = cough;
	}
	public void setHeadache(Boolean headache) {
		Headache = headache;
	}
	public void setBody_aches(Boolean body_aches) {
		Body_aches = body_aches;
	}
	public void setBreathing_Trouble(Boolean breathing_Trouble) {
		Breathing_Trouble = breathing_Trouble;
	}
	public void setVomiting(Boolean vomiting) {
		Vomiting = vomiting;
	}
		
	public void setAdvice(String advice) {
		Advice = advice;
	}
    
}

