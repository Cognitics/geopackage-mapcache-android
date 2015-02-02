package mil.nga.giat.geopackage.geom;

/**
 * GeoPackage Geometry
 * 
 * @author osbornb
 */
public abstract class GeoPackageGeometry {

	/**
	 * Geometry type
	 */
	private final GeoPackageGeometryType geometryType;

	/**
	 * Has z coordinates
	 */
	private final boolean hasZ;

	/**
	 * Has m values
	 */
	private final boolean hasM;

	/**
	 * Constructor
	 * 
	 * @param geometryType
	 * @param hasZ
	 * @param hasM
	 */
	protected GeoPackageGeometry(GeoPackageGeometryType geometryType, boolean hasZ,
			boolean hasM) {
		this.geometryType = geometryType;
		this.hasZ = hasZ;
		this.hasM = hasM;
	}

	public GeoPackageGeometryType getGeometryType() {
		return geometryType;
	}

	public boolean hasZ() {
		return hasZ;
	}

	public boolean hasM() {
		return hasM;
	}

	/**
	 * Get the Well-Known Binary code
	 * 
	 * @return
	 */
	public int getWkbCode() {
		int code = geometryType.getCode();
		if (hasZ) {
			code += 1000;
		}
		if (hasM) {
			code += 2000;
		}
		return code;
	}

}
