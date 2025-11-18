import com.formdev.flatlaf.FlatLightLaf;

public class themes
	extends FlatLightLaf
{
	public static final String NAME = "themes";

	public static boolean setup() {
		return setup( new themes() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, themes.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
