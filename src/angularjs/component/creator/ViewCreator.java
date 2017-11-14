
package angularjs.component.creator;

public class ViewCreator extends Creator{
    
    private final String viewName;
    private final String viewPath;
    
    public ViewCreator(String viewName){
        this.viewName = viewName;
        this.viewPath = "C:\\angularComponents\\" + viewName + "\\" + viewName;     
        
        createFiles();        
    }

    private void createFiles() {
        createFile(viewPath, ".scss", "");
        createFile(viewPath, ".html", viewName);
        createFile(viewPath, ".js", getControllerText());
        createFile(viewPath, ".service.js", getServiceText());
        createFile(viewPath, ".module.js", getModuleText());           
    }
    
    
    private String getControllerText() {
        StringBuilder b = new StringBuilder();
        
        b.append("import './").append(viewName).append(".scss'; \n\n\n")
        .append("export default class ").append(viewName).append("Controller").append(" { \n")
        .append("\tconstructor($log){ \n")
        .append("\t\t'ngInject';\n")
        .append("\t\tthis.$log = $log;\n\t}\n}\n");
        
        return b.toString();
    }

    private String getModuleText() {        
        StringBuilder b = new StringBuilder();
        b.append("import ").append(viewName).append("Controller").append(" from './").append(viewName).append(".js';\n");
        b.append("import ").append(viewName).append("Service").append(" from './").append(viewName).append(".service.js';\n\n");
        b.append("export default angular.module('views.").append(viewName).append("', [\n\n])\n");
        b.append(".controller('").append(viewName).append("Controller', ").append(viewName).append("Controller").append(")\n");
        b.append(".service('").append(viewName).append("Service', ").append(viewName).append("Service").append(")\n");
        b.append(".name;");
        
        return b.toString();
    }

    private String getServiceText() {
        StringBuilder b = new StringBuilder();
        
        b.append("export default class ").append(viewName).append("Service").append(" { \n")
        .append("\tconstructor($log){ \n")
        .append("\t\t'ngInject';\n")
        .append("\t\tthis.$log = $log;\n\t}\n}\n");
        
        return b.toString();      
    }

}
