package apt;

import java.util.Collection;
import java.util.Map;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.AnnotationMirror;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.AnnotationTypeElementDeclaration;
import com.sun.mirror.declaration.AnnotationValue;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.util.SourcePosition;

public class BusinessKeyAnnotationProcessor implements AnnotationProcessor {

	private AnnotationProcessorEnvironment environment;

	private AnnotationTypeDeclaration businessKeyDeclaration;
	
	public BusinessKeyAnnotationProcessor() {
		super();
	}

	public BusinessKeyAnnotationProcessor(
			AnnotationProcessorEnvironment environment) {
		super();
		this.environment = environment;

		businessKeyDeclaration = (AnnotationTypeDeclaration) environment
				.getTypeDeclaration("annotation.BusinessKey");
	}

	@Override
	public void process() {
		Collection<Declaration> declarations = environment
				.getDeclarationsAnnotatedWith(businessKeyDeclaration);
		for (Declaration declaration : declarations) {
			processNoteAnnotations(declaration);
		}
	}

	private void processNoteAnnotations(Declaration declaration) {
		Collection<AnnotationMirror> annotations = declaration
				.getAnnotationMirrors();
		for (AnnotationMirror mirror : annotations) {
			if (mirror.getAnnotationType().getDeclaration()
					.equals(businessKeyDeclaration)) {

				SourcePosition position = mirror.getPosition();
				Map<AnnotationTypeElementDeclaration, AnnotationValue> values = mirror
						.getElementValues();

				System.out.println("Declaration: " + declaration.toString());
				System.out.println("Position: " + position);
				System.out.println("Values:");
				for (Map.Entry<AnnotationTypeElementDeclaration, AnnotationValue> entry : values
						.entrySet()) {
					AnnotationTypeElementDeclaration elemDecl = entry.getKey();
					AnnotationValue value = entry.getValue();
					System.out.println("    " + elemDecl + "=" + value);
				}
			}
		}
	}

}
