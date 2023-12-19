package org.demo.config.analyzer;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class ConfigurationFailureAnalyzer implements FailureAnalyzer {
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        if (failure instanceof ConfigurationException) {
            return new FailureAnalysis(
                "La configuration a échoué.",
                "Veuillez vérifier le fichier de propriétés pour des configurations valides.",
                failure);
        }
        return null;
    }
}