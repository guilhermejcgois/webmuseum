package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Guilherme Gois
 */
public final class MuseologicalObjectControllerTest {
//    
//    private DateFormat dateFormat;
//    private List<MuseologicalObject> objects;
//    private MuseologicalObjectService service;
//    
//    @Test
//    public void runTests() throws ParseException {
//        List<MuseologicalObject> initialState = new ArrayList<>();
//        for (Iterator<MuseologicalObject> iterator = objects.iterator(); iterator.hasNext();)
//            initialState.add(iterator.next());
//        
//        testList(true);
//        /*testForm();
//        testAddWithInternalParseException();
//        testList(true);
//        testAddObject();
//        testList(false);
//        objects = service.listObjects();
//        testAddImage();
//        testList(false);
//        objects = service.listObjects();
//        Long id = objects.get(objects.size() - 1).getId();
//        testEditObject(id);
//        testUpdateWithParseException(id);
//        testList(true);
//        testUpdate(id);
//        testList(false);
//        objects = service.listObjects();
//        testDelete(id);
//        testList(false);
//        objects = service.listObjects();
//        testList(true);
//        assertThat(objects, is(initialState));*/
//    }
//    
//    @Before
//    public void init() throws Exception {
//        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        service = new MuseologicalObjectService();
//        objects = service.listObjects();
//    }
//    
//    @After
//    public void destroy() throws Exception {        
//        objects = null;
//        service = null;
//        dateFormat = null;
//    }
//
//    /**
//     * Test of form method, of class MuseologicalObjectController.
//     */
//    public void testForm() {
//        System.out.println("form");
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        ModelAndView expResult = new ModelAndView("object/form");
//        ModelAndView result = instance.form();
//        assertThat(result, is(expResult));
//    }
//
//    /**
//     * Test of list method, of class MuseologicalObjectController.
//     * @param shouldBeEqual
//     */
//    public void testList(boolean shouldBeEqual) {
//        System.out.println("list");
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        ModelAndView expResult = new ModelAndView("object/list");
//        expResult.addObject("list", objects);
//        expResult.addObject("format", new SimpleDateFormat("dd/MM/yyyy"));
//        ModelAndView result = instance.list();
//        assertThat(result.getViewName(), is(expResult.getViewName()));
//        assertThat(result.getModel().get("format"), is(expResult.getModel().get("format")));
//        if (shouldBeEqual)
//            assertThat(compare((List<MuseologicalObject>) result.getModel().get("list"), (List<MuseologicalObject>) expResult.getModel().get("list")), is(true));
//        else
//            assertThat(result, not(expResult));
//    }
//
//    /**
//     * Test of addObject method (without url), of class MuseologicalObjectController.
//     * @throws java.text.ParseException
//     */
//    public void testAddObject() throws ParseException {
//        System.out.println("addObject");
//        String name = "Arco de Robin Hood";
//        String date = "21/07/2015";
//        String url = "";
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        ModelAndView expResult = new ModelAndView("object/created");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateFormat.parse(date));
//        expResult.addObject("object", new MuseologicalObjectBuilder().build(name, calendar));
//        expResult.addObject("format", dateFormat);
//        ModelAndView result = instance.addObject(name, date, url);
//        assertThat(result, is(expResult));
//    }
//
//    /**
//     * Test of addObject method (with url), of class MuseologicalObjectController.
//     * @throws java.text.ParseException
//     */
//    public void testAddImage() throws ParseException {
//        System.out.println("addObject");
//        String name = "Arco de Robin Hood";
//        String date = "21/07/2015";
//        String url = "http://www.txantxikuarkulariak.org/fitxategiak/arkua-ARE.jpg";
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        ModelAndView expResult = new ModelAndView("object/created");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateFormat.parse(date));
//        expResult.addObject("object", new MuseologicalObjectBuilder().build(name, calendar));
//        expResult.addObject("format", dateFormat);
//        ModelAndView result = instance.addObject(name, date, url);
//        assertThat(result, is(expResult));
//    }
//    
//    /**
//     * Test of addObject method (with wrong date), of class MuseologicalObjectController.
//     * @throws java.text.ParseException
//     */
//    public void testAddWithInternalParseException() throws ParseException {
//        System.out.println("addObject");
//        String name = "Arco de Robin Hood";
//        String date = "21/07/2015";
//        String url = "http://www.txantxikuarkulariak.org/fitxategiak/arkua-ARE.jpg";
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        ModelAndView expResult = new ModelAndView("object/error");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateFormat.parse(date));
//        expResult.addObject("object", new MuseologicalObjectBuilder().build(name, calendar));
//        expResult.addObject("format", dateFormat);
//        ModelAndView result = instance.addObject(name, "21 de julho de 2015", url);
//        assertThat(result, is(expResult));
//    }
//
//    /**
//     * Test of editObject method, of class MuseologicalObjectController.
//     * @param id
//     */
//    public void testEditObject(Long id) {
//        System.out.println("editObject");
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        ModelAndView expResult = new ModelAndView("object/edit");
//        expResult.addObject("object", service.findById(id));
//        expResult.addObject("format", dateFormat);
//        ModelAndView result = instance.editObject(id);
//        assertThat(result, is(expResult));
//    }
//
//    /**
//     * Test of delete method, of class MuseologicalObjectController.
//     * @param id
//     */
//    public void testDelete(Long id) {
//        System.out.println("delete");
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        String expResult = "redirect:/object";
//        String result = instance.delete(id);
//        assertThat(result, is(expResult));
//    }
//
//    /**
//     * Test of update method, of class MuseologicalObjectController.
//     * @param id
//     */
//    public void testUpdate(Long id) {
//        System.out.println("update");
//        String name = "Arco de Robin Hud";
//        String date = "20/06/2014";
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        String expResult = "redirect:/object";
//        String result = instance.update(id, name, date);
//        assertThat(result, is(expResult));
//    }
//
//    /**
//     * Test of update method, of class MuseologicalObjectController.
//     * @param id
//     */
//    public void testUpdateWithParseException(Long id) {
//        System.out.println("update");
//        String name = "Arco de Robin Hud";
//        String date = "20 de junho de dois mil e quatorze";
//        MuseologicalObjectController instance = new MuseologicalObjectController();
//        String expResult = "redirect:/object/error";
//        String result = instance.update(id, name, date);
//        assertThat(result, is(expResult));
//    }
//    
//    public boolean compare(List<MuseologicalObject> _1, List<MuseologicalObject> _2) {
//        Comparator c = new Comparator<MuseologicalObject>() {
//
//            @Override
//            public int compare(MuseologicalObject o1, MuseologicalObject o2) {
//                long l1 = o1.getId();
//                long l2 = o2.getId();
//                
//                if (l1 == l2) return 0;
//                else if (l1 > l2) return 1;
//                else return -1;
//            }
//        };
//        
//        _1.sort(c);
//        _2.sort(c);
//        
//        if (_1.size() != _2.size()) return false;
//        
//        MuseologicalObject o1, o2;
//        for (int i = 0; i < _1.size(); i++) {
//            o1 = _1.get(i);
//            o2 = _2.get(i);
//            
//            if (o1.getId().longValue() == o2.getId().longValue()) return false;
//            //if (!(o1.getClass().equals(o2.getClass()))) return false;
//            //if (o1.getName().compareTo(o2.getName()) != 0) return false;
//            //if (o1.getDate().getTimeInMillis() != o2.getDate().getTimeInMillis()) return false;
//            //if (o1.getClass().equals(Image.class))
//              //  if (((Image) o1).getUrlAddress().compareTo(((Image) o2).getUrlAddress()) != 0) return false;
//        }
//        
//        return true;
//    }
    
}
