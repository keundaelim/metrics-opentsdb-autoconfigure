# metrics-opentsdb-autoconfigure

Spring Boot 2 Auto-Configuration for micrometer-registry-opentsdb 

## Usage

add it in your build.gradle

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
	dependencies {
	        implementation 'com.github.sett4:metrics-opentsdb-autoconfigure:2.0.0-SNAPSHOT-1'
	}
```

add it in your application.yml

```yaml
management:
  metrics:
    export:
      opentsdb:
        uri: "http://example.com:${openTsdbPort}"
        step: 30s
        enabled: true
        # optional: if your OpenTSDB needs authentication        
        userName: ${openTsdbUsername} 
        password: ${openTsdbPassword}
```

if authentication is needed, your can write some customizer. 

```java

@Configuration
public class MetricConfig {
    @Bean
    MeterRegistryCustomizer<MeterRegistry> registryCustomizer() {
        return registry -> {
            if (registry instanceof OpenTsdbMeterRegistry) {
                OpenTsdbMeterRegistry openTsdbMeterRegistry = (OpenTsdbMeterRegistry) registry;
                openTsdbMeterRegistry.setAuthenticateRequester(
                        (conn, conf) -> {
                            // write some authentication code.
                        }
                );
            }
        };
    }
}
```