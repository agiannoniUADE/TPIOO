package vista;

public class State {
  String current;
  String enviorment;
  public State() {
    standby();
  }

  public void setEnv(String env) {
    this.enviorment = env;
  }

  public String getEnv() {
    return this.enviorment;
  }

  public void setCurrent(String curr) {
    this.current = curr;
  }

  public String getCurrent() {
    return this.current;
  }

  public void standby() {
    this.current = "Standby";
    this.enviorment = "none";
  }

}
