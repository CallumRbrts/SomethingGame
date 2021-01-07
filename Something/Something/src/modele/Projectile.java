package modele;

public class Projectile extends Entity {
    private int power;
    private static int length;
    private static int width;

    /**
     * Get la valeur de power
     * @return int
     */
    public int getPower() {
        return power;
    }
    /**
     * Set la valeur de power
     * @param power
     * @return
     */
    public void setPower(int power) {
        this.power = power;
    }
    /**
     *
     * Retourne la valeur de length
     * @return int
     */
    public static int getLength() {
        return length;
    }
    /**
     * Set la valeur de length
     * @param length
     * @return
     */
    public static void setLength(int length) {
        Projectile.length = length;
    }
    /**
     * Retourne la valeur de l'epaisseur du projectile
     * @return int
     */
    public static int getWidth() {
        return width;
    }
    /**
     * Set la valeur de width
     * @param width
     * @return
     */
    public static void setWidth(int width) {
        Projectile.width = width;
    }
    private static String srcImg = "resource/image/spritemagicattacknormalcroped.png";
    /**
     * Retourne l'url de l'image
     * @return String
     */
    public static String getSrcImg() {
        return srcImg;
    }
    /**
     * Set l'url de l'image
     * @param srcImg
     * @return
     */
    public static void setSrcImg(String srcImg) {
        Projectile.srcImg = srcImg;
    }
    private String direction;
    /**
     * Retourne la direction
     * @return String
     */
    public String getDirection() {
        return direction;
    }
    /**
     * Set l'attribut direction
     * @param direction
     * @return
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
    /**
     * Constructeur de Projectile
     * @param speed
     * @param power
     * @param x
     * @param y
     * @param width
     * @param length
     * @param img
     * @param direction
     * @return
     */
    public Projectile(int speed, int power, double x, double y, int length, int width, String img, String direction ){
        super(speed,x,y,img);
        setPower(power);
        setLength(length);
        setWidth(width);
        setDirection(direction);
    }
}
