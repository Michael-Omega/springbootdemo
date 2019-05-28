package cn.louiswu.config;

public final class SpringBootVersion {

    private SpringBootVersion() {
    }

    /**
     * Return the full version string of the present Spring Boot codebase, or {@code null}
     * if it cannot be determined.
     * @return the version of Spring Boot or {@code null}
     * @see Package#getImplementationVersion()
     */
    public static String getVersion() {
        Package pkg = SpringBootVersion.class.getPackage();
        return (pkg != null ? pkg.getImplementationVersion() : null);
    }

}

