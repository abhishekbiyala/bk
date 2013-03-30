package apt;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.apt.AnnotationProcessors;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

public class BusinessAnnotationProcessorFactory implements
		AnnotationProcessorFactory {

	@Override
	public AnnotationProcessor getProcessorFor(
			Set<AnnotationTypeDeclaration> declarations,
			AnnotationProcessorEnvironment env) {
		AnnotationProcessor result;
		if (declarations.isEmpty()) {
			result = AnnotationProcessors.NO_OP;
		} else {
			result = new BusinessKeyAnnotationProcessor(env);
		}
		return result;
	}

	@Override
	public Collection<String> supportedAnnotationTypes() {
		return Collections.singletonList("annotation.BusinessKey");
	}

	@Override
	public Collection<String> supportedOptions() {
		return Collections.emptyList();
	}

}
