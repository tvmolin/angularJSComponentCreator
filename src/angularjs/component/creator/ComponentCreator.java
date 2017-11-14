
package angularjs.component.creator;

public class ComponentCreator extends Creator{
    
    private final String componentName;
    private final String componentPath;
    
    public ComponentCreator(String componentName){
        this.componentName = componentName;
        componentPath = "C:\\angularComponents\\" + componentName + "\\" + componentName;     
        
        createFiles();                           
    } 
    
    private void createFiles() {
        createFile(componentPath, ".scss", "");
        createFile(componentPath, ".html", componentName);
        createFile(componentPath, ".js", getControllerText());
        createFile(componentPath, ".service.js", getServiceText());
        createFile(componentPath, ".module.js", getModuleText());    
    }
    
    private String getControllerText() {
        StringBuilder b = new StringBuilder();
        
        b.append("import './").append(componentName).append(".scss'; \n\n\n")
        .append("class ").append(componentName).append("Controller").append(" { \n")
        .append("\tconstructor($log){ \n")
        .append("\t\t'ngInject';\n")
        .append("\t\tthis.$log = $log;\n\t}\n}\n")
        .append("\nexport default {\n")
        .append("\ttemplate: require('./").append(componentName).append(".html'), \n")
        .append("\tcontroller: ").append(componentName).append("Controller").append(", \n")
        .append("\tbindings: {\n\n\t}, \n};");
        return b.toString();
    }

    private String getModuleText() {        
        StringBuilder b = new StringBuilder();
        b.append("import ").append(componentName).append("Controller").append(" from './").append(componentName).append(".js';\n");
        b.append("import ").append(componentName).append("Service").append(" from './").append(componentName).append(".service.js';\n\n");
        b.append("export default angular.module('components.").append(componentName).append("', [\n\n])\n");
        b.append(".component('").append(componentName).append("', ").append(componentName).append("Controller").append(")\n");
        b.append(".service('").append(componentName).append("Service', ").append(componentName).append("Service").append(")\n");
        b.append(".name;");
        
        return b.toString();
    }

    private String getServiceText() {
        StringBuilder b = new StringBuilder();
        
        b.append("export default class ").append(componentName).append("Service").append(" { \n")
        .append("\tconstructor($log){ \n")
        .append("\t\t'ngInject';\n")
        .append("\t\tthis.$log = $log;\n\t}\n}\n");
        
        return b.toString();      
    }

  
    
}
