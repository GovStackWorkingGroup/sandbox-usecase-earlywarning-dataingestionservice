package global.govstack.data_ingestion.dto;

import java.util.List;

public record ThreatDto(String threatType, String severity, List<String> affectedCountries, List<String> affectedCounties, String range, String periodStart, String periodEnd) {
}
