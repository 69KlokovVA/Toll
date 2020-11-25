package jdev.dto;


public class PointRequestDTO {

    private  String device;
    private int maxNumberOfPoints;

    public  String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getMaxNumberOfPoints() {
        return maxNumberOfPoints;
    }

    public void setMaxNumberOfPoints(int maxNumberOfPoints) {
        this.maxNumberOfPoints = maxNumberOfPoints;
    }
}
